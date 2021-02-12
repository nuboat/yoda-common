/*
 * Copyright (c) 2020. Peerapat Asoktummarungsri <https://www.linkedin.com/in/peerapat>
 */

package yoda.commons

import scala.reflect.runtime.universe._


/**
  * Provides functionality for obtaining reflective information about
  * classes constructor and objects.
  *
  * @author Peerapat A on April 21, 2018
  */
trait AnnotationHelper {

  type AnnotationName = String
  type AnnotationField = String
  type PropertyName = String
  type MethodName = String

  /**
    * Returns a `Map` from annotation names to annotation data for
    * the specified type.
    *
    * @tparam T The type to get class annotations for.
    * @return The class annotations for `T`.
    */
  def classAnnotations[T: TypeTag]: Map[AnnotationName, Map[AnnotationField, String]] = {
    typeOf[T].typeSymbol.asClass.annotations
      .map(a => annotationName(a) -> extractChild(a.tree.children))
      .toMap
  }

  /**
    * Returns a `Map` from method names to a `Map` from annotation names to
    * annotation data for the specified type.
    *
    * @tparam T The type to get constructor annotations for.
    * @return The constructor annotations for `T`.
    */
  def constructorAnnotations[T: TypeTag]: Map[PropertyName, Map[AnnotationName, Map[AnnotationField, String]]] = {
    symbolOf[T]
      .asClass.primaryConstructor.typeSignature.paramLists.head
      .withFilter(symbol => symbol.annotations.nonEmpty)
      .map(symbol => symbol.name.toString -> extract(symbol.annotations))
      .toMap
  }

  /**
    * Returns a `Map` from method names to a `Map` from annotation names to
    * annotation data for the specified type.
    *
    * @tparam T The type to get method annotations for.
    * @return The method annotations for `T`.
    */
  def methodAnnotations[T: TypeTag]: Map[MethodName, Map[AnnotationName, Map[AnnotationField, String]]] = {
    typeOf[T].decls.collect { case m: MethodSymbol => m }
      .withFilter(method => method.annotations.nonEmpty)
      .map(method => method.name.toString -> extract(method.annotations))
      .toMap
  }

  private def extract(annotations: List[Annotation]): Map[AnnotationName, Map[AnnotationField, String]] = {
    annotations.map(a => annotationName(a) -> extractChild(a.tree.children)).toMap
  }

  private def extractChild(children: List[Tree]): Map[AnnotationField, String] = children
    .withFilter(_.productPrefix eq "AssignOrNamedArg")
    .map(tree => tree.productElement(0).toString.replace("\"", "") -> tree.productElement(1).toString.replace("\"", "") )
    .toMap

  private def annotationName(a: Annotation): AnnotationName = a.tree.tpe.typeSymbol.name.toString

}
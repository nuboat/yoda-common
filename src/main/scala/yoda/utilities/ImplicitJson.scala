/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.utilities

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, PropertyNamingStrategy}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.typesafe.scalalogging.LazyLogging
import scalaj.http.HttpResponse

import scala.reflect.runtime.universe.typeOf

/**
  * Created by Peerapat A on Mar 18, 2017
  */
object ImplicitJson extends LazyLogging {

  private val mapper = new ObjectMapper with ScalaObjectMapper

  mapper.registerModule(JodaJacksonModule)
  mapper.registerModule(DefaultScalaModule)
  mapper.setSerializationInclusion(Include.NON_NULL)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
  mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)

  implicit class AnyToJson(obj: AnyRef) {

    def toJson: String = mapper.writeValueAsString(obj)
  }

  implicit class PlainString(body: String) {

    def toOption[T: Manifest]: Option[T] = try {
      logger.trace(s"${typeOf[T].typeSymbol.name} - $body")
      Option(mapper.readValue[T](body))
    } catch {
      case t: Throwable =>
        logger.warn(s"Cannot transfer \n $body To: ${typeOf[T].typeSymbol.name}")
        None
    }
  }

  implicit class HTTPResponse(response: HttpResponse[String]) {

    def toOption[T: Manifest]: Option[T] = try {
      logger.trace(s"${typeOf[T].typeSymbol.name} - ${response.body}")
      Option(mapper.readValue[T](response.body))
    } catch {
      case t: Throwable =>
        logger.warn(s"Cannot transfer \n ${response.body} To: ${typeOf[T].typeSymbol.name}")
        None
    }
  }

}

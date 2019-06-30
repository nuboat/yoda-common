/*
 * Copyright (C) 2019 Peerapat Asoktummarungsri
 */

package yoda.handlers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * There is no support for runtime annotation in Scala, so far
 * Java interfaces need to be used.
 * <p>
 * Design for use in Find only
 * <p>
 * @author Peerapat A on Mar 18, 2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LocalCache {

    String prefix();

    int timeout() default 6;

}

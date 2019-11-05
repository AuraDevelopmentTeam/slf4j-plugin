package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * The binding of {@link LoggerFactory} class with an actual instance of {@link ILoggerFactory} is
 * performed using information returned by this class.
 *
 * @author Yannick Schinko
 */
public class StaticLoggerBinder implements LoggerFactoryBinder {
  /**
   * Declare the version of the SLF4J API this implementation is compiled against. The value of this
   * field is modified with each major release.
   */
  // to avoid constant folding by the compiler, this field must *not* be final
  public static String REQUESTED_API_VERSION = "@slf4j_version@"; // !final

  // TODO
  private static final String loggerFactoryClassStr = Object.class.getName();

  /** The unique instance of this class. */
  private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

  /**
   * Return the singleton of this class.
   *
   * @return the StaticLoggerBinder singleton
   */
  public static final StaticLoggerBinder getSingleton() {
    return SINGLETON;
  }

  /**
   * The ILoggerFactory instance returned by the {@link #getLoggerFactory} method should always be
   * the same object
   */
  private final ILoggerFactory loggerFactory;

  private StaticLoggerBinder() {
    // TODO
    loggerFactory = null;
  }

  public ILoggerFactory getLoggerFactory() {
    return loggerFactory;
  }

  public String getLoggerFactoryClassStr() {
    return loggerFactoryClassStr;
  }
}

package org.slf4j.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * BungeecordLoggerFactory is an implementation of {@link ILoggerFactory} returning the
 * appropriately named {@link BungeecordLoggerAdapter} instance.
 *
 * @author Yannick Schinko
 * @author Ceki G&uuml;lc&uuml;
 */
public class BungeecordLoggerFactory implements ILoggerFactory {
  // key: name (String), value: a JDK14LoggerAdapter;
  ConcurrentMap<String, Logger> loggerMap;

  public BungeecordLoggerFactory() {
    loggerMap = new ConcurrentHashMap<String, Logger>();
    // ensure jul initialization. see SLF4J-359
    // note that call to java.util.logging.LogManager.getLogManager() fails on the Google App Engine
    // platform. See SLF4J-363
    java.util.logging.Logger.getLogger("");
  }

  /*
   * (non-Javadoc)
   *
   * @see org.slf4j.ILoggerFactory#getLogger(java.lang.String)
   */
  public Logger getLogger(String name) {
    // the root logger is called "" in JUL
    if (name.equalsIgnoreCase(Logger.ROOT_LOGGER_NAME)) {
      name = "";
    }

    Logger slf4jLogger = loggerMap.get(name);
    if (slf4jLogger != null) return slf4jLogger;

    // In case it has *just* been added
    java.util.logging.Logger julLogger = FakePluginLogger.getLogger(name);
    Logger newInstance = new BungeecordLoggerAdapter(julLogger);
    Logger oldInstance = loggerMap.putIfAbsent(name, newInstance);
    return oldInstance == null ? newInstance : oldInstance;
  }
}

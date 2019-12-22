package org.slf4j.impl;

import cn.nukkit.utils.LogLevel;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.LoggingEvent;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

/**
 * A wrapper over {@link java.util.logging.Logger java.util.logging.Logger} in conformity with the
 * {@link Logger} interface. Note that the logging levels mentioned in this class refer to those
 * defined in the java.util.logging package.
 *
 * @author Yannick Schinko
 * @author Ceki G&uuml;lc&uuml;
 * @author Peter Royal
 */
public final class NukkitLoggerAdapter extends MarkerIgnoringBase implements LocationAwareLogger {
  private static final long serialVersionUID = -1112953787988322156L;

  private static final String SELF = NukkitLoggerAdapter.class.getName();

  private final transient cn.nukkit.utils.Logger logger;

  NukkitLoggerAdapter(cn.nukkit.utils.Logger logger) {
    this.logger = logger;
  }

  /**
   * Is this logger instance enabled for the FINEST level?
   *
   * @return True if this Logger is enabled for level FINEST, false otherwise.
   */
  public boolean isTraceEnabled() {
    return false;
  }

  /**
   * Log a message object at level FINEST.
   *
   * @param msg - the message object to be logged
   */
  public void trace(String msg) {
    // Do nothing
  }

  /**
   * Log a message at level FINEST according to the specified format and argument.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for level FINEST.
   *
   * @param format the format string
   * @param arg the argument
   */
  public void trace(String format, Object arg) {
    // Do nothing
  }

  /**
   * Log a message at level FINEST according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the FINEST
   * level.
   *
   * @param format the format string
   * @param arg1 the first argument
   * @param arg2 the second argument
   */
  public void trace(String format, Object arg1, Object arg2) {
    // Do nothing
  }

  /**
   * Log a message at level FINEST according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the FINEST
   * level.
   *
   * @param format the format string
   * @param argArray an array of arguments
   */
  public void trace(String format, Object... argArray) {
    // Do nothing
  }

  /**
   * Log an exception (throwable) at level FINEST with an accompanying message.
   *
   * @param msg the message accompanying the exception
   * @param t the exception (throwable) to log
   */
  public void trace(String msg, Throwable t) {
    // Do nothing
  }

  /**
   * Is this logger instance enabled for the FINE level?
   *
   * @return True if this Logger is enabled for level FINE, false otherwise.
   */
  public boolean isDebugEnabled() {
    return true;
  }

  /**
   * Log a message object at level FINE.
   *
   * @param msg - the message object to be logged
   */
  public void debug(String msg) {
    log(SELF, LogLevel.DEBUG, msg, null);
  }

  /**
   * Log a message at level FINE according to the specified format and argument.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for level FINE.
   *
   * @param format the format string
   * @param arg the argument
   */
  public void debug(String format, Object arg) {
    FormattingTuple ft = MessageFormatter.format(format, arg);
    log(SELF, LogLevel.DEBUG, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log a message at level FINE according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the FINE level.
   *
   * @param format the format string
   * @param arg1 the first argument
   * @param arg2 the second argument
   */
  public void debug(String format, Object arg1, Object arg2) {
    FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
    log(SELF, LogLevel.DEBUG, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log a message at level FINE according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the FINE level.
   *
   * @param format the format string
   * @param argArray an array of arguments
   */
  public void debug(String format, Object... argArray) {
    FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
    log(SELF, LogLevel.DEBUG, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log an exception (throwable) at level FINE with an accompanying message.
   *
   * @param msg the message accompanying the exception
   * @param t the exception (throwable) to log
   */
  public void debug(String msg, Throwable t) {
    log(SELF, LogLevel.DEBUG, msg, t);
  }

  /**
   * Is this logger instance enabled for the INFO level?
   *
   * @return True if this Logger is enabled for the INFO level, false otherwise.
   */
  public boolean isInfoEnabled() {
    return true;
  }

  /**
   * Log a message object at the INFO level.
   *
   * @param msg - the message object to be logged
   */
  public void info(String msg) {
    log(SELF, LogLevel.INFO, msg, null);
  }

  /**
   * Log a message at level INFO according to the specified format and argument.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the INFO level.
   *
   * @param format the format string
   * @param arg the argument
   */
  public void info(String format, Object arg) {
    FormattingTuple ft = MessageFormatter.format(format, arg);
    log(SELF, LogLevel.INFO, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log a message at the INFO level according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the INFO level.
   *
   * @param format the format string
   * @param arg1 the first argument
   * @param arg2 the second argument
   */
  public void info(String format, Object arg1, Object arg2) {
    FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
    log(SELF, LogLevel.INFO, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log a message at level INFO according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the INFO level.
   *
   * @param format the format string
   * @param argArray an array of arguments
   */
  public void info(String format, Object... argArray) {
    FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
    log(SELF, LogLevel.INFO, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log an exception (throwable) at the INFO level with an accompanying message.
   *
   * @param msg the message accompanying the exception
   * @param t the exception (throwable) to log
   */
  public void info(String msg, Throwable t) {
    log(SELF, LogLevel.INFO, msg, t);
  }

  /**
   * Is this logger instance enabled for the WARNING level?
   *
   * @return True if this Logger is enabled for the WARNING level, false otherwise.
   */
  public boolean isWarnEnabled() {
    return true;
  }

  /**
   * Log a message object at the WARNING level.
   *
   * @param msg - the message object to be logged
   */
  public void warn(String msg) {
    log(SELF, LogLevel.WARNING, msg, null);
  }

  /**
   * Log a message at the WARNING level according to the specified format and argument.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the WARNING
   * level.
   *
   * @param format the format string
   * @param arg the argument
   */
  public void warn(String format, Object arg) {
    FormattingTuple ft = MessageFormatter.format(format, arg);
    log(SELF, LogLevel.WARNING, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log a message at the WARNING level according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the WARNING
   * level.
   *
   * @param format the format string
   * @param arg1 the first argument
   * @param arg2 the second argument
   */
  public void warn(String format, Object arg1, Object arg2) {
    FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
    log(SELF, LogLevel.WARNING, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log a message at level WARNING according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the WARNING
   * level.
   *
   * @param format the format string
   * @param argArray an array of arguments
   */
  public void warn(String format, Object... argArray) {
    FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
    log(SELF, LogLevel.WARNING, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log an exception (throwable) at the WARNING level with an accompanying message.
   *
   * @param msg the message accompanying the exception
   * @param t the exception (throwable) to log
   */
  public void warn(String msg, Throwable t) {
    log(SELF, LogLevel.WARNING, msg, t);
  }

  /**
   * Is this logger instance enabled for level SEVERE?
   *
   * @return True if this Logger is enabled for level SEVERE, false otherwise.
   */
  public boolean isErrorEnabled() {
    return true;
  }

  /**
   * Log a message object at the SEVERE level.
   *
   * @param msg - the message object to be logged
   */
  public void error(String msg) {
    log(SELF, LogLevel.ERROR, msg, null);
  }

  /**
   * Log a message at the SEVERE level according to the specified format and argument.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the SEVERE
   * level.
   *
   * @param format the format string
   * @param arg the argument
   */
  public void error(String format, Object arg) {
    FormattingTuple ft = MessageFormatter.format(format, arg);
    log(SELF, LogLevel.ERROR, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log a message at the SEVERE level according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the SEVERE
   * level.
   *
   * @param format the format string
   * @param arg1 the first argument
   * @param arg2 the second argument
   */
  public void error(String format, Object arg1, Object arg2) {
    FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
    log(SELF, LogLevel.ERROR, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log a message at level SEVERE according to the specified format and arguments.
   *
   * <p>This form avoids superfluous object creation when the logger is disabled for the SEVERE
   * level.
   *
   * @param format the format string
   * @param arguments an array of arguments
   */
  public void error(String format, Object... arguments) {
    FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
    log(SELF, LogLevel.ERROR, ft.getMessage(), ft.getThrowable());
  }

  /**
   * Log an exception (throwable) at the SEVERE level with an accompanying message.
   *
   * @param msg the message accompanying the exception
   * @param t the exception (throwable) to log
   */
  public void error(String msg, Throwable t) {
    log(SELF, LogLevel.ERROR, msg, t);
  }

  /**
   * Log the message at the specified level with the specified throwable if any. This method creates
   * a LogRecord and fills in caller date before calling this instance's JDK14 logger.
   */
  private void log(String callerFQCN, LogLevel level, String msg, Throwable t) {
    log(level, msg, t);
  }

  /**
   * Log the message at the specified level with the specified throwable if any. This method creates
   * a LogRecord and fills in caller date before calling this instance's JDK14 logger.
   */
  private void log(LogLevel level, String msg, Throwable t) {
    logger.log(level, msg, t);
  }

  public void log(
      Marker marker, String callerFQCN, int level, String message, Object[] argArray, Throwable t) {
    LogLevel nukkitLevel = slf4jLevelIntToNukkitLevel(level);
    log(nukkitLevel, message, t);
  }

  private LogLevel slf4jLevelIntToNukkitLevel(int slf4jLevelInt) {
    LogLevel nukkitLevel;
    switch (slf4jLevelInt) {
      case LocationAwareLogger.TRACE_INT:
        nukkitLevel = LogLevel.DEBUG;
        break;
      case LocationAwareLogger.DEBUG_INT:
        nukkitLevel = LogLevel.DEBUG;
        break;
      case LocationAwareLogger.INFO_INT:
        nukkitLevel = LogLevel.INFO;
        break;
      case LocationAwareLogger.WARN_INT:
        nukkitLevel = LogLevel.WARNING;
        break;
      case LocationAwareLogger.ERROR_INT:
        nukkitLevel = LogLevel.ERROR;
        break;
      default:
        throw new IllegalStateException("Level number " + slf4jLevelInt + " is not recognized.");
    }
    return nukkitLevel;
  }

  /** @since 1.7.15 */
  public void log(LoggingEvent event) {
    LogLevel nukkitLevel = slf4jLevelIntToNukkitLevel(event.getLevel().toInt());
    String format = event.getMessage();
    Object[] arguments = event.getArgumentArray();
    FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
    if (ft.getThrowable() != null && event.getThrowable() != null) {
      throw new IllegalArgumentException(
          "both last element in argument array and last argument are of type Throwable");
    }

    if (ft.getThrowable() != null) {
      // ??? Taken from the original. No idea why that code is like that...
      // t = ft.getThrowable();
      throw new IllegalStateException("fix above code");
    }

    log(nukkitLevel, ft.getMessage(), event.getThrowable());
  }
}

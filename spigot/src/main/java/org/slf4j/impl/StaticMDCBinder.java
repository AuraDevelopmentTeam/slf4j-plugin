package org.slf4j.impl;

import org.slf4j.helpers.BasicMDCAdapter;
import org.slf4j.spi.MDCAdapter;

/**
 * This implementation is bound to {@link BasicMDCAdapter}.
 *
 * @author Yannick Schinko
 * @author Ceki G&uuml;lc&uuml;
 */
public class StaticMDCBinder {
  /** The unique instance of this class. */
  public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();

  private StaticMDCBinder() {}

  /**
   * Return the singleton of this class.
   *
   * @return the StaticMDCBinder singleton
   * @since 1.7.14
   */
  public static final StaticMDCBinder getSingleton() {
    return SINGLETON;
  }

  /**
   * Currently this method always returns an instance of {@link BasicMDCAdapter}.
   *
   * @return never null.
   */
  public MDCAdapter getMDCA() {
    return new BasicMDCAdapter();
  }

  public String getMDCAdapterClassStr() {
    return BasicMDCAdapter.class.getName();
  }
}

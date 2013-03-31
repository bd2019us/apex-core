/*
 *  Copyright (c) 2012-2013 Malhar, Inc.
 *  All Rights Reserved.
 */
package com.malhartech.bufferserver.support;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Chetan Narsude <chetan@malhar-inc.com>
 */
public class Publisher extends com.malhartech.bufferserver.client.Publisher
{
  public Publisher(String id)
  {
    super(id);
  }

  @Override
  public String toString()
  {
    return "BufferServerPublisher";
  }

  @Override
  public void onMessage(byte[] buffer, int offset, int size)
  {
    logger.warn("received data when unexpected {}", Arrays.toString(Arrays.copyOfRange(buffer, offset, size)));
  }

  public void publishMessage(byte[] payload)
  {
    write(payload);
  }

  public void activate(int baseSeconds, int windowId)
  {
    super.activate((long)baseSeconds << 32 | windowId);
  }

  private static final Logger logger = LoggerFactory.getLogger(Publisher.class);
}
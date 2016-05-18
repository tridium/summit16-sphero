/**
 *
 */
package com.tridium.sphero.message;

/**
 *  - Insert description here.
 *
 * @author Robert Adams
 * @creation Mar 17, 2014
 *
 */
public class AcknowledgeMsg
    extends SpheroMessage
{

  /**
   * 
   */
  public AcknowledgeMsg(int seq)
  {
    super(seq);
  }
  
  protected boolean isAck() { return true; }

}

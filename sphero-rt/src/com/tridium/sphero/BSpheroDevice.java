/**

 */
package com.tridium.sphero;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.status.BStatus;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;

import com.tridium.sphero.datatypes.BRollParameters;
import com.tridium.sphero.message.Roll;
import com.tridium.sphero.message.SpheroPing;
import com.tridium.sphero.point.*;


/**
 *  BSpheroDevice models a single device
 *
 *  @author   Robert Adams
 *  @creation 28-Apr-16 
 */
@NiagaraType
@NiagaraProperty(name = "status", type = "BStatus",  defaultValue = "BStatus.ok",
   flags = Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY | Flags.DEFAULT_ON_CLONE,
   facets = { @Facet("SfUtil.incl(SfUtil.MGR_EDIT_READONLY)") },
   override = true
)
@NiagaraProperty(name = "pollFrequency", type = "BPollFrequency",  defaultValue = "BPollFrequency.normal")
@NiagaraProperty(name = "points", type = "BSpheroPointDeviceExt",  defaultValue = "new BSpheroPointDeviceExt()")
@NiagaraAction(name= "roll", parameterType= "BRollParameters", defaultValue= "new BRollParameters()")
public class BSpheroDevice
  extends BNDevice
  implements BINPollable
{
  
  // Add facet to include following in auto manager view
//  public static final Property status = newProperty(Flags.TRANSIENT|Flags.READONLY|Flags.SUMMARY|Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));



/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridium.sphero.BSpheroDevice(4072413083)1.0$ @*/
/* Generated Tue May 03 11:37:08 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "status"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code status} property.
   * @see #getStatus
   * @see #setStatus
   */
  public static final Property status = newProperty(Flags.TRANSIENT | Flags.READONLY | Flags.SUMMARY| Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));

////////////////////////////////////////////////////////////////
// Property "pollFrequency"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pollFrequency} property.
   * @see #getPollFrequency
   * @see #setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal, null);
  
  /**
   * Get the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }
  
  /**
   * Set the {@code pollFrequency} property.
   * @see #pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency, v, null); }

////////////////////////////////////////////////////////////////
// Property "points"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code points} property.
   * @see #getPoints
   * @see #setPoints
   */
  public static final Property points = newProperty(0, new BSpheroPointDeviceExt(), null);
  
  /**
   * Get the {@code points} property.
   * @see #points
   */
  public BSpheroPointDeviceExt getPoints() { return (BSpheroPointDeviceExt)get(points); }
  
  /**
   * Set the {@code points} property.
   * @see #points
   */
  public void setPoints(BSpheroPointDeviceExt v) { set(points, v, null); }

////////////////////////////////////////////////////////////////
// Action "roll"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code roll} action.
   * @see #roll(BRollParameters parameter)
   */
  public static final Action roll = newAction(0, new BRollParameters(), null);
  
  /**
   * Invoke the {@code roll} action.
   * @see #roll
   */
  public void roll(BRollParameters parameter) { invoke(roll, parameter, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroDevice.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  
////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////
  
  /**
   * Returns the network type that the device runs on.
   * @return Type object representing the network
   */
  public Type getNetworkType() { return BSpheroNetwork.TYPE; }  
  
  
  /**
   * Override started 
   */
  public void started()
    throws Exception
  {
    super.started();
    
    // register device with poll scheduler 
    getSpheroNetwork().getPollScheduler().subscribe(this);
  }
  
  /**
   * Override stopped 
   */
  public void stopped()
    throws Exception
  {
    // unregister device with poll scheduler 
    getSpheroNetwork().getPollScheduler().unsubscribe(this);
    super.stopped();
  }
  
  
////////////////////////////////////////////////////////////////
// Implementation
////////////////////////////////////////////////////////////////
  /**
   *
   */
  public void doPing()
  {
    try
    {
      SpheroPing msg = new SpheroPing();
      getSpheroNetwork().scomm().sendRequest(msg);
      pingOk();
    }
    catch(Exception e)
    {
      pingFail("not receiving response from device ");
    }
  }


  public void doRoll(BRollParameters rp)
  {
    try
    {
      Roll msg = new Roll(rp.getSpeed(),rp.getHeading(), 1);
      getSpheroNetwork().scomm().sendRequest(msg);
    }
    catch(Exception e)
    {
      System.out.println("roll failed ");
    }

  }

////////////////////////////////////////////////////////////////
// Polling support
////////////////////////////////////////////////////////////////

  /**
   * The poll() callback method called from BPollScheduler
   * when it is time to poll this object.
   */
  public void doPoll()
  {
    // TODO add poll support
  }
  
////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////
  /**
   * Get the network cast to a BSpheroNetwork.
   * @return network as a BSpheroNetwork.
   */
  public final BSpheroNetwork getSpheroNetwork()
  {
    return (BSpheroNetwork)getNetwork();
  }


  
}

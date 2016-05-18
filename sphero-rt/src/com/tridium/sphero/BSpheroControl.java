/**
 *
 */
package com.tridium.sphero;

import javax.baja.sys.Action;
import javax.baja.sys.BComponent;
import javax.baja.sys.BFacets;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.units.UnitDatabase;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.NComm;
import com.tridium.sphero.datatypes.BRollParameters;
import com.tridium.sphero.message.Roll;

/**
 *  This component is used to control sphero 
 *
 * @author Robert Adams
 * @creation Mar 18, 2014
 *
 */
public class BSpheroControl
    extends BComponent
{
  /*-
  class BSpheroControl
  {
    properties
    {
      enable : boolean
        default {[ false ]}
        flags { transient }
        
      speed : int
        default {[ 0 ]}
        slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("meters per minute"), 1, 0, 255) ]}
      
      heading : int
        default {[ 0 ]}
        slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("degrees angular"), 1, 0, 359)]}
      
      offset : int
        default {[ 0 ]}
        slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("degrees angular"), 1, 0, 359)]}
    }
    actions
    {
      startSphero()
      stopSphero()
      roll( param :  BRollParameters )
         default {[ new BRollParameters() ]}
    }
    topics
    {
      
    }
  }
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridium.sphero.BSpheroControl(2985735872)1.0$ @*/
/* Generated Fri Apr 04 16:25:40 EDT 2014 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "enable"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>enable</code> property.
   * @see com.tridium.sphero.BSpheroControl#getEnable
   * @see com.tridium.sphero.BSpheroControl#setEnable
   */
  public static final Property enable = newProperty(Flags.TRANSIENT, false,null);
  
  /**
   * Get the <code>enable</code> property.
   * @see com.tridium.sphero.BSpheroControl#enable
   */
  public boolean getEnable() { return getBoolean(enable); }
  
  /**
   * Set the <code>enable</code> property.
   * @see com.tridium.sphero.BSpheroControl#enable
   */
  public void setEnable(boolean v) { setBoolean(enable,v,null); }

////////////////////////////////////////////////////////////////
// Property "speed"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>speed</code> property.
   * @see com.tridium.sphero.BSpheroControl#getSpeed
   * @see com.tridium.sphero.BSpheroControl#setSpeed
   */
  public static final Property speed = newProperty(0, 0,BFacets.makeNumeric(UnitDatabase.getUnit("meters per minute"), 1, 0, 255));
  
  /**
   * Get the <code>speed</code> property.
   * @see com.tridium.sphero.BSpheroControl#speed
   */
  public int getSpeed() { return getInt(speed); }
  
  /**
   * Set the <code>speed</code> property.
   * @see com.tridium.sphero.BSpheroControl#speed
   */
  public void setSpeed(int v) { setInt(speed,v,null); }

////////////////////////////////////////////////////////////////
// Property "heading"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>heading</code> property.
   * @see com.tridium.sphero.BSpheroControl#getHeading
   * @see com.tridium.sphero.BSpheroControl#setHeading
   */
  public static final Property heading = newProperty(0, 0,BFacets.makeNumeric(UnitDatabase.getUnit("degrees angular"), 1, 0, 359));
  
  /**
   * Get the <code>heading</code> property.
   * @see com.tridium.sphero.BSpheroControl#heading
   */
  public int getHeading() { return getInt(heading); }
  
  /**
   * Set the <code>heading</code> property.
   * @see com.tridium.sphero.BSpheroControl#heading
   */
  public void setHeading(int v) { setInt(heading,v,null); }

////////////////////////////////////////////////////////////////
// Property "offset"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>offset</code> property.
   * @see com.tridium.sphero.BSpheroControl#getOffset
   * @see com.tridium.sphero.BSpheroControl#setOffset
   */
  public static final Property offset = newProperty(0, 0,BFacets.makeNumeric(UnitDatabase.getUnit("degrees angular"), 1, 0, 359));
  
  /**
   * Get the <code>offset</code> property.
   * @see com.tridium.sphero.BSpheroControl#offset
   */
  public int getOffset() { return getInt(offset); }
  
  /**
   * Set the <code>offset</code> property.
   * @see com.tridium.sphero.BSpheroControl#offset
   */
  public void setOffset(int v) { setInt(offset,v,null); }

////////////////////////////////////////////////////////////////
// Action "startSphero"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>startSphero</code> action.
   * @see com.tridium.sphero.BSpheroControl#startSphero()
   */
  public static final Action startSphero = newAction(0,null);
  
  /**
   * Invoke the <code>startSphero</code> action.
   * @see com.tridium.sphero.BSpheroControl#startSphero
   */
  public void startSphero() { invoke(startSphero,null,null); }

////////////////////////////////////////////////////////////////
// Action "stopSphero"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>stopSphero</code> action.
   * @see com.tridium.sphero.BSpheroControl#stopSphero()
   */
  public static final Action stopSphero = newAction(0,null);
  
  /**
   * Invoke the <code>stopSphero</code> action.
   * @see com.tridium.sphero.BSpheroControl#stopSphero
   */
  public void stopSphero() { invoke(stopSphero,null,null); }

////////////////////////////////////////////////////////////////
// Action "roll"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>roll</code> action.
   * @see com.tridium.sphero.BSpheroControl#roll()
   */
  public static final Action roll = newAction(0,new BRollParameters(),null);
  
  /**
   * Invoke the <code>roll</code> action.
   * @see com.tridium.sphero.BSpheroControl#roll
   */
  public void roll(BRollParameters param) { invoke(roll,param,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroControl.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BSpheroNetwork;
  }
  
  public void started()
    throws Exception
  {
    super.started();
    updtThread = new Thread(updater, "Sphero.updater");
    updtThread.start();
  }

  public void stopped()
    throws Exception
  {
    super.stopped();
    updater.done = true;
    updtThread.interrupt();
  }
  
  public void changed(Property property, Context context)
  {
    super.changed(property, context);
    if(!isRunning()) return;
    
    if(BNNetwork.noWrite.equals(context)) { System.out.println("BNNetwork.noWrite"); return;  }
    updater.update();  
  }
  
  public void doStopSphero()
  {
    setEnable(false);
    doStop();
  }
  
  public void doStartSphero()
  {
    setEnable(true);
    updater.update();
  }
  
  public void doRoll(BRollParameters rp)
  {
    try
    {
      setInt(speed, rp.getSpeed(), BNNetwork.noWrite);
      setInt(heading, rp.getHeading(), BNNetwork.noWrite);
      updater.update();
    }
    catch(Exception e)
    {
      System.out.println("roll failed ");
    }
    
  }
  
  private void doStop()
  {
    try
    {
      Roll msg = new Roll(0, getHeading(), 1);
      scomm().sendRequest(msg);
    }
    catch(Exception e)
    {
      System.out.println("roll failed ");
    }
  }
  
  private class Updater
    implements Runnable
  {
    public void run()
    {
      while(!done)
      {
        synchronized(sync)
        {
          if(!updt) try {  sync.wait(); } catch(Exception e) {}
        }
        if(done) return;
        updt = false;
        try
        {
          Roll msg = new Roll(getSpeed(),getHeading(), 1);
          scomm().sendRequest(msg);
        }
        catch(Exception e)
        {
          System.out.println("roll failed ");
        } 
      }
    }
    
    void update()
    {
      if(!getEnable()) return;
      synchronized(sync)
      {
        updt = true;
        sync.notify();
      }
    }
    
    boolean done = false;
    boolean updt = false;
    Object  sync = new Object();

  }
  
  private NComm scomm() { return ((BSpheroNetwork)getParent()).scomm(); }
  
  Thread updtThread;
  Updater updater = new Updater();
  
}

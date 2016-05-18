/**

 */
package com.tridium.sphero.comm;

import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.nre.annotations.*;

import com.tridium.ndriver.comm.IMessageFactory;
import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NLinkMessageFactory;
import com.tridium.ndriver.datatypes.BSerialCommConfig;

import com.tridium.sphero.message.SpheroMessageFactory;

/**
 * BSpheroSerialCommConfig Handles the serial communication for the driver. 
 *
 * @author   Robert Adams
 * @creation 28-Apr-16 
 *
 */
@NiagaraType
public class BSpheroSerialCommConfig
  extends BSerialCommConfig
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridium.sphero.comm.BSpheroSerialCommConfig(2979906276)1.0$ @*/
/* Generated Thu Apr 28 17:24:18 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroSerialCommConfig.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /** Empty constructor  */
  public BSpheroSerialCommConfig() {  }
  
//  /** Override to configure the maximum number of request messages that can
//   *  be outstanding at the same time.  Default implementation returns 32. */
  public int getMaxOutstandingTransactions() { return 1; }

  /** Provide custom LinkMessage factory.   */
  protected NLinkMessageFactory makeLinkMessageFactory()
  {    
    // link message factory must create
    return new NLinkMessageFactory(1024)
      {
        protected LinkMessage createLinkMessage()
        {
          return new SpheroLinkMessage(1024); 
        }
      };
  }
  
  /** Provide custom Message factory.   */
  protected IMessageFactory makeMessageFactory()
  {
    return new SpheroMessageFactory();
  }
  
}

/**
 *
 */
package com.tridium.sphero.ui;

import javax.baja.gx.BFont;
import javax.baja.sys.Action;
import javax.baja.sys.BObject;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.ui.BButton;
import javax.baja.ui.BLabel;
import javax.baja.ui.BTextField;
import javax.baja.ui.BWidget;
import javax.baja.ui.Command;
import javax.baja.ui.CommandArtifact;
import javax.baja.ui.enums.BHalign;
import javax.baja.ui.event.BKeyEvent;
import javax.baja.ui.pane.BBorderPane;
import javax.baja.ui.pane.BEdgePane;
import javax.baja.ui.pane.BFlowPane;
import javax.baja.ui.pane.BGridPane;
import javax.baja.workbench.view.BWbComponentView;

import com.tridium.ndriver.BNNetwork;
import com.tridium.sphero.BSpheroControl;
import com.tridium.sphero.BSpheroNetwork;
import com.tridium.sphero.datatypes.BRollParameters;
import com.tridium.ui.theme.Theme;
import javax.baja.nre.annotations.*;

/**
 *  Control widget
 *
 * @author Robert Adams
 * @creation Mar 20, 2014
 *
 */
@NiagaraType(agent=@AgentOn(types={"sphero:SpheroControl"}))
@NiagaraAction(name= "control", parameterType= "BKeyEvent", defaultValue= "new BKeyEvent()", flags= Flags.HIDDEN)
public class BSpheroDialog
    extends BWbComponentView
{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.tridium.sphero.ui.BSpheroDialog(700485526)1.0$ @*/
/* Generated Thu May 05 13:58:00 EDT 2016 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Action "control"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code control} action.
   * @see #control(BKeyEvent parameter)
   */
  public static final Action control = newAction(Flags.HIDDEN, new BKeyEvent(), null);
  
  /**
   * Invoke the {@code control} action.
   * @see #control
   */
  public void control(BKeyEvent parameter) { invoke(control, parameter, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpheroDialog.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

 public BSpheroDialog() {}


//  /**
//   * 
//   */
//  public BSpheroDialog(BSpheroNetwork net)
//  {
//    super(null, "Sphero Control", true);
//    this.net = net;
//
//  }
  public void doLoadValue(BObject val, Context cx)
  {
    con = (BSpheroControl)val;
    net = (BSpheroNetwork)con.getParent();
    offset = con.getOffset();
    
    BGridPane gp = new BGridPane(2);
    gp.setColumnGap(10);
    gp.setRowGap(10);
    
    gp.add("hdl", new BLabel("Heading"));
    gp.add("hd", headingTf);
    gp.add("spl", new BLabel("Speed"));
    gp.add("sp", speedTf);
    gp.add("offl", new BLabel("Offset"));
    gp.add("off", offsetTf);
    
    BTextField tf = new BTextField("", 40, true);
    
    
    Command enableCommand = new Command(getWbShell(), "enable")
    {
      public CommandArtifact doInvoke()
      {
        con.setEnable(true);
        return null;
      }
    };
    enableBtn = new BButton(enableCommand, true, true);
    Command disableCommand = new Command(getWbShell(), "disable")
    {
      public CommandArtifact doInvoke()
      {
        con.setEnable(false);
        return null;
      }
    };
    disableBtn = new BButton(disableCommand, true, true);
    
    BFlowPane buttonPane = new BFlowPane(BHalign.center);
    buttonPane.add("enable", enableBtn);
    buttonPane.add("disable", disableBtn);
        
    BEdgePane ep = new BEdgePane();
    ep.setTop(gp);
    ep.setCenter(new BBorderPane(buttonPane,10,10,10,10));
    BEdgePane ep1 = new BEdgePane();
    
    BLabel bnr = new BLabel("Sphero control", BHalign.center);
    BFont fnt = Theme.label().getTextFont(bnr);
    bnr.setFont(BFont.make(fnt.getName(), fnt.getSize() * 1.1, BFont.BOLD));

    ep1.setTop(new BBorderPane(bnr,10,10,10,10));
    ep1.setCenter(new BBorderPane(ep,10,10,10,10));
    ep1.setBottom(tf); ;
    
    setContent(ep1);
    linkTo(tf, BWidget.keyEvent, control);
//    linkTo(gp, BWidget.keyEvent, control);
//    linkTo(speedTf, BWidget.keyEvent, control);
//    linkTo(headingTf, BWidget.keyEvent, control);
//    linkTo(ep, BWidget.keyEvent, control);
  }
  BTextField speedTf    = new BTextField("0", 10, false);
  BTextField headingTf  = new BTextField("0",10, false);
  BTextField offsetTf    = new BTextField("0",10, false);
  BButton enableBtn;
  BButton disableBtn;
  
  public void keyPressed(BKeyEvent ke)
  {
    System.out.println("press " + ke.toString(null));
    super.keyTyped(ke);
  }
  public void keyTyped(BKeyEvent ke)
  {
    System.out.println("type " + ke.toString(null));
    super.keyTyped(ke);
  }
  public void doControl(BKeyEvent ke)
  {
   // System.out.println("con " + ke.toString(null));
    if(ke.getId()==BKeyEvent.KEY_TYPED) 
    {
      switch(ke.getKeyChar())
      {
        // Set direction
        case 'q':  setHead(-45);  break;  
        case 'w':  setHead(0);    break; 
        case 'e':  setHead(45);   break; 
        case 'a':  setHead(-90);  break; 
        case 's':  nextSpeed=speed; speed=0;   break;  
        case 'd':  setHead(90);   break;  
        case 'z':  setHead(-145); break;  
        case 'x':  setHead(180);  break;  
        case 'c':  setHead(145);  break; 
        
        // Align heading
        case 'h':  adjHeadOffset(20);  break;  
        case 'j':  adjHeadOffset(5);  break;  
        case 'k':  adjHeadOffset(-5);   break;  
        case 'l':  adjHeadOffset(-20);   break;  
        
        // Adjust speed
        case 'n':  adjSpeed(50);  break;  // faster
        case 'm':  adjSpeed(30);  break;  // faster
        case ',':  adjSpeed(10);  break;  // faster
        case '.':  adjSpeed(-30); break;  // slower
        case '/':  adjSpeed(-50); break;  // slower
        case ' ':  speed = 0;  nextSpeed=0;   break;  // stop
        default : System.out.println(ke.getKeyChar() + " " + Integer.toString(ke.getKeyChar(),16));
      }
      update();
    }
  }
  void adjSpeed(int inc)
  {
    if(speed==0)
    {
      nextSpeed += inc;
      if(nextSpeed>255) nextSpeed = 255;
      if(nextSpeed<0) nextSpeed = 0;
      setSpeed = nextSpeed;
    }
    else
    {
      speed += inc;
      if(speed>255) speed = 255;
      if(speed<0) speed = 0;
      setSpeed = speed;
    }
  }
  void adjHeadOffset(int inc)
  {
    offset += inc;
    con.setInt(BSpheroControl.offset, offset, BNNetwork.noWrite);
  }
  void setHead(int v)
  {
    if(speed==0) speed = nextSpeed;
    
    heading = v + offset;
    if(heading>359) heading -= 360;
    if(heading<0) heading += 360;
    setheading = v;
  }
  
  private void  update()
  {
    offsetTf.setText(Integer.toString(offset));
    speedTf.setText(Integer.toString(setSpeed));
    headingTf.setText(Integer.toString(setheading));
    
    con.roll(new BRollParameters(speed,heading));
  }

  int heading = 0;
  int setheading = 0;  // desired heading without offset - for display
  int speed = 0;
  int nextSpeed = 0;
  int setSpeed = 0;   // desired speed when moving
  int offset = 0;
  BSpheroControl con;
  BSpheroNetwork net;
  


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author kevin
 */


/**
 *
 * Clase controlladora del timer
 * 
 */
public class KTimer extends Thread {

private Thread thread = null; 
private SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S"); 
private String[] split; 
private SimpleStringProperty min, sec, millis, sspTime; 
private long time; 

public static void main(String[] args) { 
    KTimer t = new KTimer(); 
    t.startTimer(00); 
} 
/**
 *
 * contructor que inicia las variables que se ocupan
 * 
 */
public KTimer() { 
    min = new SimpleStringProperty("00"); 
    sec = new SimpleStringProperty("00"); 
    millis = new SimpleStringProperty("00"); 
    sspTime = new SimpleStringProperty("00:00:00"); 
} 
/**
 *
 * inicia el hilo
 * 
 */
public void startTimer(long time) { 
    this.time = time; 
    thread = new Thread(this); 
    thread.setPriority(Thread.MIN_PRIORITY); 
    thread.start(); 
} 

/**
 *
 * 
 * detiene el cronometro
 * 
 */
public void stopTimer(long time) { 
    if (thread != null) { 
     thread.interrupt(); 
    } 
    this.time = time; 
    setTime(time); 
} 

/**
 *
 * indica los numeros que va a tener el label
 * 
 * 
 */
public void setTime(long time) { 
    this.time = time; 
    split = sdf.format(new Date(time)).split(":"); 
    min.set(split[0]); 
    sec.set(split[1]); 

    if (split[2].length() == 1) { 
     split[2] = "0" + split[2]; 
    } 
    millis.set(split[2].substring(0, 2)); 

    sspTime.set(min.get() + ":" + sec.get() + ":" + millis.get()); 
} 

public long getTime() { 
    return time; 
} 

public SimpleStringProperty getSspTime() { 
    return sspTime; 
} 
/**
 *
 * hace correr 
 * 
 */
@Override 
public void run() { 
    try { 
     while (!thread.isInterrupted()) { 
      setTime(time); 
      sleep(10); 
      time = time + 10; 
     } 
    } catch (Exception e) { 
    } 

}
    
}

package com.FintechChatBot;

import javax.speech.*;
import java.util.*;
import javax.speech.synthesis.*;

public class Text2Speech
{
    String speaktext;

    public void dospeak(String speak,String  voicename)
    {
        speaktext=speak;
        String voiceName =voicename;
        try
        {
            SynthesizerModeDesc desc = new SynthesizerModeDesc(null,"general",  Locale.US,null,null);
            Synthesizer synthesizer =  Central.createSynthesizer(desc);
            synthesizer.allocate();
            synthesizer.resume();
            desc = (SynthesizerModeDesc)  synthesizer.getEngineModeDesc();
            Voice[] voices = desc.getVoices();
            Voice voice = null;
            for (int i = 0; i < voices.length; i++)
            {
                if (voices[i].getName().equals(voiceName))
                {
                    voice = voices[i];
                    break;
                }
            }
            synthesizer.getSynthesizerProperties().setVoice(voice);
            System.out.print("Speaking : "+speaktext);
            synthesizer.speakPlainText(speaktext, null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            synthesizer.deallocate();
        }
        catch (Exception e)
        {
            String message = " missing speech.properties in " + System.getProperty("user.home") + "\n";
            System.out.println(""+e);
            System.out.println(message);
        }
    }

    public static void main(String[] args) throws Throwable
    {
        Text2Speech obj=new Text2Speech();
        Text2Speech obj1=new Text2Speech(); 
        obj.dospeak("hi chinmay,how are you","kevin");
        
        obj1.dospeak("how are you","kevin16");
    }
}
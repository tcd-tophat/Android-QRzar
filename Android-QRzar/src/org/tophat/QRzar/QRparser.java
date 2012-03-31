package org.tophat.QRzar;

/**
 * Parses the team join QR code in order to the user to join a specific game.
 * @author Kevin
 *
 */
public class QRparser
{

    private String data = "";

    public QRparser(String QRinput)
    {
    	//Clone the string
        data = new String ( QRinput);   
    }

    public String getTeam()
    {
    	
        if(data.charAt(0) == 'R')
        {
            return "red";
        }
        else if(data.charAt(0) == 'B')
        {
            return "blue";
        }
        else if(data.charAt(0) == 'G')
        {
            return "green";
        }
        else if(data.charAt(0) == 'Y')
        {
            return "yellow";
        }
        
		return null;
    }

    public int getGameId()
    {
        int res = 0;
        res += (int)data.charAt(1);
        res = res << (int) Math.pow( (double) 2, (double)8);
        res += (int)data.charAt(2);
        res = res << (int) Math.pow( (double)2, (double)8);
        res += (int)data.charAt(3);
        return res;
    }

    public int getPlayerId()
    {
        int res = 0;
        res += (int)data.charAt(4);
        res = res << (int)Math.pow((double)2, (double)8);
        res += (int)data.charAt(5);
        return res;
    }
}

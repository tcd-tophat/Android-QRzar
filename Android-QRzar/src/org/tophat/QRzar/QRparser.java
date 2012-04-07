package org.tophat.QRzar;

/**
 * Parses the team join QR code in order to the user to join a specific game.
 * @author Kevin
 *
 */
public class QRparser
{

    private String data = "";
    
    /**
     * So that the team only needs to be extracted once in order to be used, it is saved in this variable after one
     */
    private String team;
    
    /**
     * The game Id is saved in here after one in order to ensure that it does not have to be recalculated.
     */
    private Integer gameId;
    
    /**
     * This playerId
     */
    private Integer playerId;
    
    private boolean valid;

    public QRparser(String QRinput)
    {
    	//Clone the string
        data = new String ( QRinput);  
        
        if ( data.length() != 6)
        {
        	this.valid = false;
        }
        else
        {
        	this.valid = true;
        }
    }

    public String getTeam()
    {
    	if( team == null )
    	{
	        if(data.charAt(0) == 'R')
	        {
	            team = "red";
	        }
	        else if(data.charAt(0) == 'B')
	        {
	            team = "blue";
	        }
	        else if(data.charAt(0) == 'G')
	        {
	            team = "green";
	        }
	        else if(data.charAt(0) == 'Y')
	        {
	            team = "yellow";
	        }
    	}
        
		return team;
    }

    public int getGameId()
    {
    	if( gameId == null )
    	{
	        gameId = 0;
	        gameId += (int)data.charAt(1);
	        gameId = gameId << (int) Math.pow( (double) 2, (double)8);
	        gameId += (int)data.charAt(2);
	        gameId = gameId << (int) Math.pow( (double)2, (double)8);
	        gameId += (int)data.charAt(3);
    	}
    	
    	return (int)gameId;
    }

    public int getPlayerId()
    {
        int res = 0;
        res += (int)data.charAt(4);
        res = res << (int)Math.pow((double)2, (double)8);
        res += (int)data.charAt(5);
        return res;
    }
    
    public boolean isValid()
    {
    	return this.valid;
    }
}

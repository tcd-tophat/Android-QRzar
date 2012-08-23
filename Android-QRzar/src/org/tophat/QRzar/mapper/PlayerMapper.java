package org.tophat.QRzar.mapper;

import java.util.Map;

import org.tophat.QRzar.models.Player;
import org.tophat.android.networking.ApiCommunicator;

/**
 * This is an extension to the default SDK mapper in order to support the new attributes that have been added to the player object very quickly.
 * @author Kevin
 */
public class PlayerMapper extends org.tophat.android.model.PlayerMapper 
{

	public PlayerMapper(ApiCommunicator apic) 
	{
		super(apic);
	}
	
	@Override
	protected Player creator(Map<String, Object> data)
	{
		return new Player(data);
	}
}

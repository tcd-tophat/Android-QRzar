package org.tophat.QRzar.models;

import java.util.Map;

import org.tophat.android.mapping.Game;
import org.tophat.android.mapping.User;

import android.os.Parcel;

public class Player extends org.tophat.android.mapping.Player {

	private Boolean alive;
	private String team;
	private String qrcode;
	
	public Player(Map<String, Object> data)
	{
		super(data);
		
		if (data.containsKey("alive"))
			this.setAlive((Boolean)data.get("alive"));
		
		if (data.containsKey("team"))
			this.setTeam((String) data.get("team"));
		
		if (data.containsKey("qrcode"))
			this.setQrcode((String) data.get("qrcode"));
	}
	
	// Parcelling part
	public Player(Parcel in){
		super(in);
		
		this.setAlive(Boolean.parseBoolean(in.readString()));
		this.setQrcode(in.readString());
		this.setTeam(in.readString());
	}
	
	/**
	 * @return the alive
	 */
	public Boolean getAlive() {
		return alive;
	}
	/**
	 * @param alive the alive to set
	 */
	public void setAlive(Boolean alive) {
		this.alive = alive;
	}
	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}
	/**
	 * @return the qrcode
	 */
	public String getQrcode() {
		return qrcode;
	}
	/**
	 * @param qrcode the qrcode to set
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		super.writeToParcel(dest, flags);
		
		dest.writeString(this.getAlive().toString());
		dest.writeString(this.getQrcode());
		dest.writeString(this.getTeam());
	}
}

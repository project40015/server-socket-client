package decimate.WarSocket;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserPunishmentEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
	private int id;
	private String type;
	private String reason;
	private long applied;
	private long expiration;
	private String punisherUuid;
	private String punishedUuid;
    
    public UserPunishmentEvent(int id, String type, String reason, long applied, long expiration, String punisherUuid, String punishedUuid){
    	this.id = id;
    	this.type = type;
    	this.reason = reason;
    	this.applied = applied;
    	this.expiration = expiration;
    	this.punisherUuid = punisherUuid;
    	this.punishedUuid = punishedUuid;
    }
    
	public int getId(){
		return id;
	}
	
	public String getType(){
		return type;
	}
	
	public String getReason(){
		return reason;
	}
	
	public long getApplied(){
		return applied;
	}
	
	public long getExpiration(){
		return expiration;
	}
	
	public String getPunisherUUID(){
		return punisherUuid;
	}
	
	public String getPunishedUUID(){
		return punishedUuid;
	}
	
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}

package decimate.WarSocket;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ServerInformationPacketResultEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
	private String uuid, rank, faction;
    
    public ServerInformationPacketResultEvent(String uuid, String rank, String faction){
    	this.uuid = uuid;
    	this.rank = rank;
    	this.faction = faction;
    }
    
    public String getRank(){
    	return rank;
    }
    
    public String getFaction(){
    	return faction;
    }
    
    public String getUUID(){
    	return this.uuid;
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}

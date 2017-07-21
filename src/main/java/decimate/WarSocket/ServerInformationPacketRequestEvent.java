package decimate.WarSocket;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ServerInformationPacketRequestEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
	private String uuid;
    
    public ServerInformationPacketRequestEvent(String uuid){
    	this.uuid = uuid;
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

package decimate.WarSocket;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserRevertPunishmentEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
	private int id;
    
    public UserRevertPunishmentEvent(int id){
    	this.id = id;
    }
    
	public int getId(){
		return id;
	}
	
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}

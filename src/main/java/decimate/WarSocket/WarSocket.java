package decimate.WarSocket;

import java.net.URISyntaxException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class WarSocket extends JavaPlugin {

	private Socket socket;
	private static WarSocket instance;
	
	@Override
	public void onEnable(){
		instance = this;
		try {
			setupSocket();
		} catch (URISyntaxException e) {
			Bukkit.broadcastMessage(ChatColor.RED + "Serious error. Contact _Ug for support.");
			e.printStackTrace();
		}
	}
	
	public void emitServerInformationPacketRequest(String uuid){
	    socket.emit("server-information-packet-request", uuid);
	}
	
	public void emitServerInformationPacketResult(String uuid, String rank, String faction){
		socket.emit("server-information-packet-result", uuid, rank, faction);
	}
	
	public void emitUserPunishment(int id, String type, String reason, long applied, long expiration, String punisherUuid, String punishedUuid){
		socket.emit("punishment", id, type, reason, applied + "", expiration + "", punisherUuid, punishedUuid);
	}
	
	public void emitUserRevertPunishment(int id){
		socket.emit("revert-punishment", id);
	}
	
	public static WarSocket getInstance(){
		return instance;
	}
	
	private void setupSocket() throws URISyntaxException{
    	socket = IO.socket("http://104.194.206.120:3000");
    	socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

    	  public void call(Object... args) {
    		  System.out.println("Connected to socket.");
    	  }

    	}).on("server-information-packet-request", new Emitter.Listener() {

    	  public void call(Object... args) {
    		  Bukkit.getServer().getPluginManager().callEvent(new ServerInformationPacketRequestEvent((String) args[0]));
    	  }

    	}).on("server-information-packet-result", new Emitter.Listener() {

      	  public void call(Object... args) {
    		  Bukkit.getServer().getPluginManager().callEvent(new ServerInformationPacketResultEvent((String) args[0], (String) args[1], (String) args[2]));
      	  }

      	}).on("punishment", new Emitter.Listener() {

       	  public void call(Object... args) {
        	  Bukkit.getServer().getPluginManager().callEvent(new UserPunishmentEvent((Integer) args[0], (String) args[1], (String) args[2], Long.valueOf((String) args[3]), Long.valueOf((String) args[4]), (String) args[5], (String) args[6]));
       	  }

        }).on("revert-punishment", new Emitter.Listener() {

       	  public void call(Object... args) {
        	  Bukkit.getServer().getPluginManager().callEvent(new UserRevertPunishmentEvent((Integer) args[0]));
       	  }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

    	  public void call(Object... args) {
    		  System.out.println("Lost connection to socket.");
    	  }

    	});
    	socket.connect();
	}
	
}

public class QRparser{

    private String data = "";

    public QRparser(String QRinput){
        data = QRinput.clone();   
    }

    public String getTeam(){
        if(data.charAt(0) == 'R'){
            return "red";
        }
        if(data.charAt(0) == 'B'){
            return "blue";
        }
        if(data.charAt(0) == 'G'){
            return "green";
        }
        if(data.charAt(0) == 'Y'){
            return "yellow";
        }
    }

    public int getGameId(){
        int res = 0;
        res += (int)data.charAt(1);
        res << Math.pow(2, 8);
        res += (int)data.charAt(2);
        res << Math.pow(2, 8);
        res += (int)data.charAt(3);
        return res;
    }

    public int getPlayerId(){
        int res = 0;
        res += (int)data.charAt(4);
        res << Math.pow(2, 8);
        res += (int)data.chatAt(5);
        return res;
    }
}

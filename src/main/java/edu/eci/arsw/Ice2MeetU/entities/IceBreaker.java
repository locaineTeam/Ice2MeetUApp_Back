package edu.eci.arsw.Ice2MeetU.entities;

public class IceBreaker {
    private String iceBreakerBody;
    public IceBreaker(){
    }

    public IceBreaker(String iceBreakerText){
        iceBreakerBody=iceBreakerText;
    }

    public String getIceBreakerBody() {
        return iceBreakerBody;
    }

    public void setIceBreakerBody(String iceBreakerBody) {
        this.iceBreakerBody = iceBreakerBody;
    }
}

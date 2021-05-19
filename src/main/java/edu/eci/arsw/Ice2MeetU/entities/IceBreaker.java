package edu.eci.arsw.Ice2MeetU.entities;

/**
 * The type Ice breaker.
 */
public class IceBreaker {
    private String iceBreakerBody;

    /**
     * Instantiates a new Ice breaker.
     */
    public IceBreaker(){
    }

    /**
     * Instantiates a new Ice breaker.
     *
     * @param iceBreakerText the ice breaker text
     */
    public IceBreaker(String iceBreakerText){
        iceBreakerBody=iceBreakerText;
    }

    /**
     * Gets ice breaker body.
     *
     * @return the ice breaker body
     */
    public String getIceBreakerBody() {
        return iceBreakerBody;
    }

    /**
     * Sets ice breaker body.
     *
     * @param iceBreakerBody the ice breaker body
     */
    public void setIceBreakerBody(String iceBreakerBody) {
        this.iceBreakerBody = iceBreakerBody;
    }
}

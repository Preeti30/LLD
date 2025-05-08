public class Player {
    int id;

    public Player(int id, int current_position) {
        this.id = id;
        this.current_position = current_position;
    }

    public int getCurrent_position() {
        return current_position;
    }

    public void setCurrent_position(int current_position) {
        this.current_position = current_position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int current_position;


}

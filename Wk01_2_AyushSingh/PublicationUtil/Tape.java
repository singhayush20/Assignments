class Tape extends Publication {
    float playingTime;

    public Tape(String title, float price, float playingTime) {
        super(title, price);
        this.playingTime = playingTime;
    }
}
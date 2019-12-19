package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.image.BufferedImage;

public class Shape implements GameObject, Shapes {
    private static final int SPRITES_NUMBER = 1;

    private BufferedImage[] spriteImages = new BufferedImage[SPRITES_NUMBER];
    private int x;
    private int y;
    private boolean visible;
    private boolean use;

    public Shape(int posX, int posY){
        this.x = posX;
        this.y = posY;
        this.visible = true;
        this.use = false;

        // Create a buffered image
        spriteImages[0] = ImageFactoryImplementation.getInstance().createImage();
    }

    public Shape(Shape shape) {
        this.x = shape.getX();
        this.y = shape.getY();
        this.visible = true;
        this.use = shape.isused();

        this.spriteImages[0] = shape.getSpriteImages()[0];
    }

    public Shape(int posX, int posY, boolean used, BufferedImage image) {
        this.x = posX;
        this.y = posY;
        this.visible = true;
        this.use = used;

        this.spriteImages[0] = image;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return this.spriteImages;
    }

    @Override
    public int getWidth(){
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean isused() {
        return use;
    }

    @Override
    public void use(boolean used) {
        this.use = used;
    }

    @Override
    public boolean isSimilar(GameObject shape1, GameObject shape2, GameObject shape3) {
        // Get center pixels colors
        int centerColor1 = shape1.getSpriteImages()[0].getRGB(shape1.getX() + shape1.getWidth() / 2, shape1.getY() + shape1.getHeight() / 2);
        int centerColor2 = shape2.getSpriteImages()[0].getRGB(shape2.getX() + shape2.getWidth() / 2, shape2.getY() + shape2.getHeight() / 2);
        int centerColor3 = shape3.getSpriteImages()[0].getRGB(shape3.getX() + shape3.getWidth() / 2, shape3.getY() + shape3.getHeight() / 2);

        // If colors are similar
        return (centerColor1 == centerColor2) && (centerColor2 == centerColor3);
    }

    @Override
    public int getScore() {
        return 10;
    }

}

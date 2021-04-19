import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;

    public MyKeyboard(Player player) {
        keyboard = new Keyboard(this);
        this.player = player;
    }

    public void init() {

        for (KEYS key : KEYS.values()) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKey(key.getKey());
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event);
        }

        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            player.stopPaintingSquare();
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                player.moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                player.moveDown();
                break;
            case KeyboardEvent.KEY_LEFT:
                player.moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();
                break;
            case KeyboardEvent.KEY_SPACE:
                player.paintSquare();
                break;
            case KeyboardEvent.KEY_C:
                Grid.clearScreen();
                break;
            case KeyboardEvent.KEY_S:
                Saves.save();
                break;
            case KeyboardEvent.KEY_L:
                Saves.load();
                break;
            case KeyboardEvent.KEY_0:
                AttributeColors.changeToBlack();
                break;
            case KeyboardEvent.KEY_1:
                AttributeColors.changeToRed();
                break;
            case KeyboardEvent.KEY_2:
                AttributeColors.changeToOrange();
                break;
            case KeyboardEvent.KEY_3:
                AttributeColors.changeToYellow();
                break;
            case KeyboardEvent.KEY_4:
                AttributeColors.changeToBlue();
                break;
            case KeyboardEvent.KEY_5:
                AttributeColors.changeToCyan();
                break;
            case KeyboardEvent.KEY_6:
                AttributeColors.changeToGreen();
                break;
            case KeyboardEvent.KEY_7:
                AttributeColors.changeToGray();
                break;
            case KeyboardEvent.KEY_8:
                AttributeColors.changeToMagenta();
                break;
            case KeyboardEvent.KEY_9:
                AttributeColors.changeToPink();
                break;
            case KeyboardEvent.KEY_B:
                AttributeColors.rubber();
                break;
        }
    }

    public enum KEYS {
        KEY_UP(KeyboardEvent.KEY_UP),
        KEY_DOWN(KeyboardEvent.KEY_DOWN),
        KEY_LEFT(KeyboardEvent.KEY_LEFT),
        KEY_RIGHT(KeyboardEvent.KEY_RIGHT),
        KEY_SPACE(KeyboardEvent.KEY_SPACE),
        KEY_C(KeyboardEvent.KEY_C),
        KEY_S(KeyboardEvent.KEY_S),
        KEY_L(KeyboardEvent.KEY_L),
        KEY_0(KeyboardEvent.KEY_0),
        KEY_1(KeyboardEvent.KEY_1),
        KEY_2(KeyboardEvent.KEY_2),
        KEY_3(KeyboardEvent.KEY_3),
        KEY_4(KeyboardEvent.KEY_4),
        KEY_5(KeyboardEvent.KEY_5),
        KEY_6(KeyboardEvent.KEY_6),
        KEY_7(KeyboardEvent.KEY_7),
        KEY_8(KeyboardEvent.KEY_8),
        KEY_9(KeyboardEvent.KEY_9),
        KEY_B(KeyboardEvent.KEY_B);

        private int key;

        KEYS(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }
    }
}

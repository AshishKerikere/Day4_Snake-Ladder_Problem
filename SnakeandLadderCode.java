package Day4;
public class Snake_Ladder {
    public static void main(String[] args) {

        int pos1 = 0;
        int pos2 = 0;
        int dice1 = 0;
        int dice2 = 0;
        int R1 = 0;
        int R2 = 0;
        int temp_pos1 = 0;
        int temp_pos2 = 0;

        while (pos1 < 100 && pos2 < 100) {

            pos1 = dice_movement(pos1);
            dice1++;
            temp_pos1 = resultant_position(pos1);
            if (temp_pos1 != pos1){
                dice1++;
                pos1 = temp_pos1;
            }
            if (pos1 >= 100)
                break;

            pos2 = dice_movement(pos2);
            dice2++;
            temp_pos2 = resultant_position(pos2);
            if (temp_pos2 != pos2){
                dice2++;
                pos2 = temp_pos2;
            }

            if (pos2 >= 100)
                break;
        }
        System.out.println("the number of times person 1 rolled the dice was " + dice1);
        System.out.println("the number of times person 2 rolled the dice was " + dice2);
        System.out.println("The position of player1 is " + pos1);
        System.out.println("The position of player2 is " + pos2);
    }

    static int resultant_position(int P) {

        int dice_value = (int) Math.floor(Math.random() * 6 + 1);
        int rand = (int) Math.floor(Math.random() * 3 + 1);
        int post = 0;

        if (rand == 1) {
            post = P;
        } else if (rand == 2) {
            post = P - dice_value;
            if (post < 0)
                post = 0;
        } else if (rand == 3) {
            post = P + dice_value;
            if (post > 100)
                post = P;
        }
        return post;
    }

    static int dice_movement(int P) {
        int dice_value = (int) Math.floor(Math.random() * 6 + 1);
        int post = P + dice_value;

        if (post > 100) {
            return P;
        } else {
            return post;
        }
    }
}

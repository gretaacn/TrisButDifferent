package com.example.springTest.tris;

public class Tris {
    //Attributi
    private char[][] matrice;
    private boolean isGameOver;
    private char lastCharPlayed;

    //Costruttore
    public Tris(){
        this.matrice = new char[3][3];
        this.isGameOver = false;
        this.lastCharPlayed = ' ';

    }

    //Metodi

    public void mossa(int row, int col, char caracter){
        caracter = Character.toUpperCase(caracter);
        if(isCharValid(caracter, lastCharPlayed)){
            if(isPosUnused(this.matrice, row, col) && isPosValid(this.matrice, row, col)){
                this.matrice[row][col] = caracter;
                lastCharPlayed = caracter;
            }
        }
    }

    private boolean isCharValid(char unChar, char lastChar){
        lastChar = Character.toUpperCase(lastChar);
        unChar = Character.toUpperCase(unChar);
        if(lastChar == 'X' && unChar == 'O'){
            return true;
        }
        if(lastChar == 'O' && unChar == 'X'){
            return true;
        }
        if (lastChar == ' '){
            if(unChar == 'O' || unChar == 'X'){
                return true;
            }
        }

        return false;
    }

    public boolean didYouWin(char[][] matrice, int row, int col, char charInput){
        charInput = Character.toUpperCase(charInput);
        //check horizontal
        if(col == 0){
            if(matrice[row][col+1] == charInput && matrice[row][col+2] == charInput){
                isGameOver = true;
                return true;
            }
        }

        if(col == 1){
            if(matrice[row][col-1] == charInput && matrice[row][col+1] == charInput){
                isGameOver = true;
                return true;
            }
        }

        if(col == 2){
            if(matrice[row][col-2] == charInput && matrice[row][col-1] == charInput){
                isGameOver = true;
                return true;
            }
        }

        //Check vertical
        if(row==0){
            if(matrice[row+1][col] == charInput && matrice[row+2][col] == charInput){
                isGameOver = true;
                return true;
            }
        }
        if(row ==1){
            if(matrice[row-1][col] == charInput && matrice[row+1][col] == charInput){
                isGameOver = true;
                return true;
            }
        }
        if(row == 2){
            if(matrice[row-2][col] == charInput && matrice[row-1][col]== charInput){
                isGameOver = true;
                return true;
            }
        }

        //check diagonal principal
        if(row==col){
            if(matrice[0][0] == charInput && matrice[1][1] == charInput && matrice[2][2] == charInput){
                isGameOver = true;
                return true;
            }
        }
        //Check diagonal inv
        if(row + col == matrice.length-1){
            if(matrice[0][matrice.length-1] == charInput && matrice[1][1] == charInput && matrice[matrice.length-1][0] == charInput){
                isGameOver = true;
                return true;
            }
        }

        return false;
    }

    public boolean isGameOver (char[][] matrice){
        int countPosUsed = 0;
        for (int row = 0; row < matrice.length; row++) {
            for (int col = 0; col < matrice[0].length; col++) {
                if(!isPosUnused(matrice, row, col)){
                    countPosUsed++;
                }
            }
        }
        if(countPosUsed == 9){
            isGameOver = true;
            return true;
        }

        return false;

    }

    private boolean isPosUnused (char[][] matrice, int row, int col){
        if(isPosValid(matrice, row, col)){
            if(matrice[row][col] == 'X' || matrice[row][col] == 'O'){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

    private boolean isPosValid(char[][] matrice, int row, int col){
        if(row >= 0 && row <= matrice.length-1){
            if(col >=0 && col <= matrice.length-1){
                return true;
            }
        }
        return false;
    }

    public String printMatrice(char[][] matrice){
        String matriceString = "";
        for (int row = 0; row < matrice.length; row++) {
            for (int col = 0; col < matrice[0].length; col++) {

                if(col == matrice.length-1){
                    matriceString += matrice[row][col] + "\t";

                } else{
                    matriceString += matrice[row][col]+ " | ";
                }

            } matriceString+= "\n";
        }
        return matriceString;
    }

    public char[][] getMatrice() {
        return matrice;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    @Override
    public String toString() {
        return printMatrice(this.matrice);
    }
}

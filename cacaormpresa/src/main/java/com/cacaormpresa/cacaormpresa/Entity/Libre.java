package com.cacaormpresa.cacaormpresa.Entity;




public class Libre {
    private String slote1;
    private String slote2;
    private String slote3;
    private String slote4;

    public Libre(){}
/// get
    public String Entrada(int i){
        switch (i){
            case 0:
                return this.slote1;

            case 1:
                return this.slote2;

            case 2:
                return this.slote3;

            case 3:
                return this.slote4;

            default:
            return "Error de entrega ";






        }


    }




    /// set
    public void Modificacion (int i, String Entrega){
        switch (i){
            case 0:
                 this.slote1 = Entrega;
break;
            case 1:
                 this.slote2 = Entrega;
break;
            case 2:
              this.slote3 = Entrega;
break;
            case 3:
          this.slote4 = Entrega;
break;
            default:
           System.out.print("Error de entrga ");






        }


    }

}

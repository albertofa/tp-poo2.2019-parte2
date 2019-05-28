package jogo.ufc;

import java.util.Random;


public class Acao {

	public int ataque;
	public int soco;
	public int chute;
	public int poder;
	public int defesa;
	public double dano;

	public Acao(){
		dano = 2.0;
		this.sortearValores();
	}
	
	public void sortearValores(){
		
		Random sorteio = new Random();
		
		if(sorteio.nextInt(2)==0){
			this.defesa=1;
		}else{
			this.ataque=1;
			
			if(sorteio.nextInt(3)==0){
				this.chute=1;
				this.soco=0;
				this.poder=0;
			}else if(sorteio.nextInt(3)==1){
				this.chute=0;
				this.soco=1;
				this.poder=0;
			}else{
				this.chute=0;
				this.soco=0;
				this.poder=1;
			}
		}
	}
}

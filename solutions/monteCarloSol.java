public class monteCarloSol {
//what's the probability that Sean Gallagher comes third?
	public static void main (String[] args){
 double successes = 0;
 double simulations = 1000000;

 for(int i = 0; i< simulations; i++){
 double higgins = 0.98;
 double duffy = 0.001;
 double casey = 0.1;
 double freeman = 0.02;
 double riada = 0.03;
 double gallagher = 0.05;

 String[] candidatelist = new String[6];

 for(int j=0;j<6;j++){

 double totalprob=higgins+duffy+casey+freeman+riada+gallagher;
 double random = Math.random()*totalprob;
 if(random<higgins){
 candidatelist[j]="Higgins";
 higgins=0;
 }else if(random<higgins+duffy){
 candidatelist[j]="Duffy";
duffy=0;
 }else if(random<higgins+duffy+casey){
 candidatelist[j]="Casey";
casey=0;
 }else if(random<higgins+duffy+casey+freeman){
 candidatelist[j]="Freeman";
freeman=0;
 }else if(random<higgins+duffy+casey+freeman+riada){
 candidatelist[j]="Riada";
riada=0;
 }else{
 candidatelist[j]="Gallagher";
gallagher=0;
 }
 }
 if(candidatelist[2]=="Gallagher"){
 successes++;
 }
 }
 System.out.println("The probability that Gallagher comes third is
"+successes*100/simulations+"%");
 }
}

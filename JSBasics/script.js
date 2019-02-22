/*var age=18;
if(age<18){
    console.log("minor");

}else if(age>18){
    console.log("major");
}
age<=18?console.log("major"):console.log("minor");

function  trial(firstname,lastname){
    console.log(firstname+' '+lastname);
}
trial('Krithi','Shastry');

var names=["krithi's","neha","dungi"];
var i
for(i=0;i<names.length;i++){
console.log(names[i]);}
console.log(names.length);

names.push("Nayana");
names.unshift("Likhita");
names.pop();
console.log(names);*/
//Challenge 2
var b1=124;
var b2=48;
var b3=268;
var t1;
var to1;
var tip=[];
var total=[];
function tipcal(bill){
    if(bill<=50){
    t1=bill*0.2;
    tip.push(t1);
    to1=bill+t1;
    total.push(to1);
    }
    else if(bill>50&&bill<200){
        t1=bill*0.15;
        tip.push(t1);
        to1=bill+t1;
        total.push(to1);
    }
    else if(bill>=200){
        t1=bill*.1;
        tip.push(t1);
        to1=bill+t1;
        total.push(to1);
    }

}
tipcal(b1);
tipcal(b2);
tipcal(b3);
console.log(tip);
console.log(total);

/*var myDetails={
    firstname:"Krithi",
    lastname:"Shastry",
    dob: 1997,
    family:['Shama','Rajeshwari'],
    calcAge:function(birthYear){
        return 2019-birthYear;
    }
};
console.log(myDetails.firstname);
var z='dob';
console.log(myDetails[z]);

myDetails.dob=1981;
console.log(myDetails);

var shiva=new Object();
shiva.firstname='Apurva';
console.log(shiva);

console.log('Krithi is '+myDetails.calcAge(1997)+' years old');*/
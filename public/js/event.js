//tong so hinh

var total =4;
var time =5000;
var intervalId = 0;
var inc	=	1;

window.onload = function() {
setClass();
intervalId=setInterval("displaytime()", time);
};
//start =1 img dau tien

function setClass()
{
//add class for li
 	if ('arr'=='arr')
	{
		var aClass=new Array ('one','two','three','four','five','six','seven','eight','nine','ten');	
		for (i=1;i<=total;i++)
		{
			document.getElementById('c_'+i).className =aClass[i-1];
		}
	}else
	{
			for (i=1;i<=total;i++)
		{
			document.getElementById('c_'+i).className =Array ('one','two','three','four','five','six','seven','eight','nine','ten');
		}
		
	}
}
function displaytime()
{		
	move_tab_img(inc)		
	inc++;
	if(inc==total+1) inc=1;
}
	
//num vi tri move
function move_tab_img(num)
{

	BIG		=	'big_'+num
	NUM	=	'num_'+num
	// for big image
	for (i=1;i<=total;i++)
	{
		
		document.getElementById('big_'+i).style.display='none';
	}		
	document.getElementById(BIG).style.display='block';	
	//add class for number
	for (i=1;i<=total;i++)
	{
	
		document.getElementById('num_'+i).className ="";
	}	
	document.getElementById(NUM).className ="act";
			
}
function stopdisplay(num)
{	
	clearInterval(intervalId);	
	move_tab_img(num);
}
function playdisplay(num)
{
	intervalId=setInterval("displaytime()", time);
}
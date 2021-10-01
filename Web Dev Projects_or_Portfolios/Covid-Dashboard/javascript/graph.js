var xmlhttp=new XMLHttpRequest();
var url='https://data.covid19india.org/data.json';
xmlhttp.open("GET",url,true)
xmlhttp.send();
xmlhttp.onreadystatechange=function(){
    if(this.readyState==4 && this.status==200){
    var data=JSON.parse(this.responseText)
    var active={}
    for(var i=0;i<=10;i++){
         active[data.statewise[i].state]=data.statewise[i].active
    }
    var ctx = document.getElementById('canvas').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels:"",
            datasets: [{
                label: 'Total Active Cases ',
                data: active,
                backgroundColor: "transparent",
                borderColor: "#404040",
                borderWidth: 4
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    var active_1={}
    for(var i=19;i<=38;i++){
         active_1[data.statewise[i].state]=data.statewise[i].active
    }

    }   
    }

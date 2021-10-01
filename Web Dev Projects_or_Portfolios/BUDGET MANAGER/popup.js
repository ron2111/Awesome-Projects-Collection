$(function(){
    chrome.storage.sync.get(["total", "limit"],function(budget){
        $("#total").text(budget.total);
        $("limit").text(budget.limit);
    })
    
     $("#spendamount").click(function(){
        chrome.storage.sync.get(["total", "limit"],function(budget){
           var newtot=0;
           if(budget.total){
               newtot += parseInt(budget.total);
           }

            var amount = $("#amount").val();
            if(amount){
                newtot += parseInt(amount);

            }
            chrome.storage.sync.set({"total":newtot}, function(){
                if(amount && newtot >= budget.limit){
                    var notifOptions = {
                        type: "basic",
                        iconUrl: "icon48.png",
                        title: "Limit reached!",
                        message: "Hehe! paisa khatam BC"
                    };
                    chrome.notifications.create("limitNotif", notifOptions);
                }
            });
            $("#total").text(newtot);
            $("#amount").val("");
        })
     })  
});
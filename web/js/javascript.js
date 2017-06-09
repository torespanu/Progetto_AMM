/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function createElement(nrd){
    var link = $("<a>")
            .attr("href","Bacheca?user="+nrd.nerd_id)
            .html(nrd.nome+" "+nrd.cognome);
    var img = $("<img>")
            .attr("alt","Foto Nerd")
            .attr("src",nrd.urlFotoProfilo)
    return $("<li>")
            .attr("class","user")
            .append(link)
            .append(img);
}  

function stateSuccess(data){
    var userListPage = $("#listaAmici");
    
    $(userListPage).empty();
    for(var instance in data){
        $(userListPage).append(createElement(data[instance]));
    }
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchNerd").click(function(){
        
        var wantedNerd = $("#searchField")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                q: wantedNerd
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});

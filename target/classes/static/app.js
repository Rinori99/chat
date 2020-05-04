var stompClient = null;
var conversationId;
var senderId;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    conversationId = $("#conv").val();
    senderId = $("#sender").val();
    //var socket = new WebSocket('ws://localhost:8080/greetings');
    var socket = new SockJS('/messages');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
//        stompClient.subscribe('/user/queue/reply', function (greeting) {
//            showGreeting(JSON.parse(greeting.body).content);
//        });
        stompClient.subscribe('/topic/chat/' + conversationId, function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    const message = {
        senderId: senderId,
        conversationId: conversationId,
        content: $("#name").val()
    }
    stompClient.send("/app/message/" + conversationId, {}, JSON.stringify(message));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});
var gc_net = {};

gc_net.get_stars = function(callback) {
    
}

gc_net.get_star = function(callback) {
    
}

gc_net.get_planet = function(callback) {
    
}

gc_net.set_listener = function(listener) {
    this._listener=listener;
}

gc_net.start = function() {
    setTimeout(this._loop, 1000);
}

gc_net.add_server = function(url) {
    this._servers.push({url:url});
}

gc_net._servers=[];
gc_net._server=false;
gc_net._current_galaxy_id=false;
gc_net._current_galaxy_turn=false;

gc_net._loop = function() {
    
    setTimeout(this._loop, 1000);
}

gc_net._send_random_server = function(action, parameterarray, callback) {
    var server = this._servers[Math.floor(Math.random()*this._servers.length)];
    gc_net._send(server, action, parameterarray, callback);
}

gc_net._send = function(server, action, parameterarray, callback) {
    that=this;
    
    var url = server.url + "/" + action + "?" + this._encode_url_parameters(parameterarray);
    
    $.ajax({
        url: url,
        dataType:'json',
    }).done(function(response) {
        that._receive_response(server, action, parameterarray, response);
        callback(response, action, parameterarray);
    }).error(function(jqXHR, textStatus, errorThrown) {
        that._receive_error(server, action, parameterarray);
    });
}

gc_net._encode_url_parameters = function(data) {
    if (!data) return "";
    var ret = [];
    for (var d in data)
        ret.push(encodeURIComponent(d) + "=" + encodeURIComponent(data[d]));
    return ret.join("&");
}

gc_net._receive_response = function(server, action, parameterarray, response) {
    
}

gc_net._receive_error = function(server, action, parameterarray) {
    
}


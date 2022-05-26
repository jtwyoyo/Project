/* Import modules here: express, dotenv, router, path, body-parser */
const path = require("path");
const express = require("express");
const app = express();
const bp = require("body-parser");
const env = require("dotenv").config();
const mysql = require("mysql2");
const dotenv = require("dotenv");
const session = require("express-session");

var cors = require('cors');
app.use(cors());
app.set('view engine', 'hbs');

/* Router Module for handling routing */
const router = express.Router();
app.use('/', router);
router.use(bp.json())
router.use(bp.urlencoded({ extended: true}))
app.use(express.static(__dirname));

app.use(session({
	secret: 'secret',
	resave: true,
	saveUninitialized: true
}));

/* Connection to MySQL */
var connection = mysql.createConnection({
    host     : 'localhost',
	user     : 'root',
	password : 'password',
	database : 'proj_sql'
});


/* Connection to DB*/
connection.connect(function (err) {
    if (err) throw err;
    console.log("Connected DB");
});


//////////////////////////////////////////////////////////////LOGIN
app.get('/', function(request, response) {
	response.sendFile(path.join(__dirname + '/login.html'));
});

app.post('/auth', function(request, response) {
	let username = request.body.username;
	let password = request.body.password;
	if (username && password) {
		connection.query('SELECT * FROM user WHERE username = ? AND password = ?', [username, password], function(error, results, fields) {
			if (error) throw error;
			if (results.length > 0) {
				request.session.loggedin = true;
				request.session.username = username;
				response.redirect('/Proj_HomePage.html');
			} else {
				response.redirect('/');
			}			
			response.end();
		});
	} else {
		response.send('Please enter Username and Password!');
		response.end();
	}
});

app.use('/login', (req, res) => {
    console.log(req)
    res.send({
      token: 'test123'
    });
  });
/////////////////////////////////END LOGIN////////////////////////////////////////////




///////////////////////////////////////////////////////////////ADMIN///////////////////////////////////////////////////////////////////////////
// Get all user list
//PASS
router.get('/user', function (req, res){
    connection.query('SELECT * FROM user', function (error, results){
        if(error) throw error;
        return res.send({ error: false, data: results, message: 'User Lists' });
    });
});


//Insert user
//PASS
router.post('/user', function (req, res){
    console.log(req.body);
    let user = req.body.user;
    console.log(user);

    if (!user) {
        return res.status(400).send({error: true, message:'Please provide User Information'});
    }

    connection.query("INSERT INTO user SET ? ", user, function (error,results){
        if(error) throw error;
        return res.send({ error: false, data: results.affectedRows, message: 'Inserted User' });
    }); 
});

//Update User info
//PASS
router.put('/user', function (req, res){
    console.log(req.body);
    let user = req.body.user;
    console.log(user);

    if (!user) {
        return res.status(400).send({error: true, message:'Please provide User Information'});
    }

    connection.query("UPDATE user SET ? WHERE id = ?", [user, user.id], function (error, results){
        if(error) throw error;
        return res.send({ error: false, data: results.affectedRows, message: 'Updated User Infomation' });
    }); 
});

//Delete user from db
//PASS
router.delete('/user', function (req, res){
    console.log(req.body);
    let user = req.body.user.user_ID;
    console.log(user);

    if (!user) {
        return res.status(400).send({error: true, message:'Please provide User ID'});
    }

    connection.query("DELETE FROM user WHERE id = ?", user, function (error, results){
        if(error) throw error;
        return res.send({ error: false, data: results.affectedRows, message: 'Deleted User' });
    }); 
});


// Get all Content list
//PASS
router.get('/content', function (req, res){
    connection.query('SELECT * FROM Content', function (error, results){
        if(error) throw error;
        return res.send({ error: false, data: results, message: 'Content Lists' });
    });
});

router.get('/movie', function (req, res){
    connection.query('SELECT * FROM Movie', function (error, results){
        if(error) throw error;
        return res.send({ error: false, data: results, message: 'Movie Lists' });
    });
});


//Insert content
//PASS
router.post('/content', function (req, res){
    console.log(req.body);
    let content = req.body.Content;
    console.log(content);

    if (!content) {
        return res.status(400).send({error: true, message:'Please provide Content Information'});
    }

    connection.query("INSERT INTO Content SET ? ", content, function (error,results){
        if(error) throw error;
        return res.send({ error: false, data: results.affectedRows, message: 'Inserted Content' });
    }); 
});

router.post('/movie', function (req, res){
    console.log(req.body);
    let movie = req.body.Movie;
    console.log(movie);

    if (!movie) {
        return res.status(400).send({error: true, message:'Please provide Movie Information'});
    }

    connection.query("INSERT INTO Movie SET ? ", movie, function (error,results){
        if(error) throw error;
        return res.send({ error: false, data: results.affectedRows, message: 'Inserted Movie' });
    }); 
});

//Update Content info
//PASS
router.put('/content', function (req, res){
    console.log(req.body);
    let content = req.body.Content;
    console.log(content);

    if (!content) {
        return res.status(400).send({error: true, message:'Please provide Content Information'});
    }

    connection.query("UPDATE Content SET ? WHERE content_ID = ?", [content, content.content_ID], function (error, results){
        if(error) throw error;
        return res.send({ error: false, data: results.affectedRows, message: 'Updated Content Infomation' });
    }); 
});

router.put('/movie', function (req, res){
    console.log(req.body);
    let movie = req.body.Movie;
    console.log(movie);

    if (!movie) {
        return res.status(400).send({error: true, message:'Please provide movie Information'});
    }

    connection.query("UPDATE Movie SET ? WHERE id = ?", [movie, movie.id], function (error, results){
        if(error) throw error;
        return res.send({ error: false, data: results.affectedRows, message: 'Updated Movie Infomation' });
    }); 
});

//Delete Content from db
//PASS
router.delete('/content', function (req, res){
    console.log(req.body);
    let content = req.body.Content.content_ID;
    console.log(content);

    if (!content) {
        return res.status(400).send({error: true, message:'Please provide Content ID'});
    }

    connection.query("DELETE FROM Content WHERE content_ID = ?", content, function (error, results){
        if(error) throw error;
        return res.send({ error: false, data: results.affectedRows, message: 'Deleted Content' });
    }); 
});

router.delete('/movie', function (req, res){
    console.log(req.body);
    let movie = req.body.Movieid;
    console.log(movie);

    if (!movie) {
        return res.status(400).send({error: true, message:'Please provide Movie ID'});
    }

    connection.query("DELETE FROM Movie WHERE id = ?", movie, function (error, results){
        if(error) throw error;
        return res.send({ error: false, data: results.affectedRows, message: 'Deleted Movie' });
    }); 
});

//////////////////////////////////////////////////////ADMIN////////////////////////////////////////////////////////////////////////////////////

app.get('/homepage', function(request, response) {
	response.sendFile(path.join(__dirname + '/Proj_HomePage.html'));
});

app.get('/aboutus', function(request, response) {
	response.sendFile(path.join(__dirname + '/realabout.html'));
});

app.get('/search', function(request, response) {
	response.sendFile(path.join(__dirname + '/search.html'));
});

app.post('/result', function(request, response) {
    var inp = request.body.searchinput;
    connection.query(`SELECT * FROM Movie WHERE movie_title LIKE "%${inp}%"`, function(error,res,field) {
        if (error) throw error;
        console.log(res);
        response.render('result',{title:'Result',result: res});
    });
});

/* Run Server */
app.listen(5000);
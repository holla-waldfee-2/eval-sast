const express = require('express');
const cookieParser = require('cookie-parser');

const app = express();
app.use(cookieParser());

const T = true;
const F = false;

app.get('/fooServlet', (req, res) => {
    eval(req.params['foo']);


    res.cookie('1', '1');

    res.cookie('2', '2', { secure: t() });

    res.cookie('3', '3', { secure: f() });

    res.cookie('4', '4', { secure: T });

    res.cookie('5', '5', { secure: F });

    res.cookie('6', '6', { secure: Bar.T });

    res.cookie('7', '7', { secure: Bar.F });

    const negParamTrue = getCookie(true);
    res.cookie(negParamTrue.name, negParamTrue.value, { secure: negParamTrue.secure });

    const posParamFalse = getCookie(false);
    res.cookie(posParamFalse.name, posParamFalse.value, { secure: posParamFalse.secure });

    let lvart = true;
    res.cookie('14', '14', { secure: lvart });

    let lvarf = false;
    res.cookie('15', '15', { secure: lvarf });

    res.cookie('16', '16', { secure: true });

    res.cookie('17', '17', { secure: false });

    res.send('Cookies set');
});

function t() {
    return true;
}

function f() {
    return false;
}

function getCookie(b) {
    return { name: 'c', value: 'c', secure: b };
}

const Bar = {
    T: true,
    F: false
};

const port = 3000;
app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});

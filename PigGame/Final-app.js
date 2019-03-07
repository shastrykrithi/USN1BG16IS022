
/*
GAME RULES:

- The game has 2 players, playing in rounds.Player enters the winning score before starting the game
- In each turn, a player rolls two dice as many times as he whishes. Each result get added to his ROUND score
- BUT, if the player rolls a 1 or consecutive two 6's in any one of the dice, all his ROUND score gets lost. After that, it's the next player's turn
- The player can choose to 'Hold', which means that his ROUND score gets added to his GLBAL score. After that, it's the next player's turn
- The first player to reach winning  points on GLOBAL score wins the game.

*/

var scores, roundScore, activePlayer, gamePlaying,prevd,prevd1,count;


init();


document.querySelector('.btn-roll').addEventListener('click', function() {
    if(gamePlaying) {
        // 1. Random number
        var dice = Math.floor(Math.random() * 6) + 1;
        var dice1= Math.floor(Math.random() * 6) + 1;
        
        //2. Display the result
        var diceDOM = document.querySelector('.dice');
        var diceDOM1 = document.querySelector('.dice1');
        diceDOM.style.display = 'block';
        diceDOM1.style.display = 'block';
        diceDOM.src = 'dice-' + dice + '.png';
        diceDOM1.src = 'dice-' + dice1 + '.png';


        //3. Update the round score IF the rolled number was NOT a 1 and no consecutive 6's
        if (dice!== 1&& dice1!==1&&((dice!==prevd||prevd!==6)&&(dice1!==prevd1||prevd1!==6))) {
            //Add score
            roundScore += dice+dice1;
            document.querySelector('#current-' + activePlayer).textContent = roundScore;
        } else {
            //Next player
            nextPlayer();
        }
         prevd=dice;
         prevd1=dice1;
         console.log(prevd);
         console.log(prevd1);
    }    
});


document.querySelector('.btn-hold').addEventListener('click', function() {
    if (gamePlaying) {
        // Add CURRENT score to GLOBAL score
        globalScores[activePlayer] += roundScore;

        // Update the UI
        document.querySelector('#score-' + activePlayer).textContent = globalScores[activePlayer];

        // Check if player won the game
        if (globalScores[activePlayer] >= count) {
            document.querySelector('#name-' + activePlayer).textContent = 'Winner!';
            document.querySelector('.dice').style.display = 'none';
            document.querySelector('.dice1').style.display = 'none';
            document.querySelector('.player-' + activePlayer + '-panel').classList.add('winner');
            document.querySelector('.player-' + activePlayer + '-panel').classList.remove('active');
            gamePlaying = false;
        } else {
            //Next player
            nextPlayer();
        }
    }
});


function nextPlayer() {
    //Next player
    activePlayer === 0 ? activePlayer = 1 : activePlayer = 0;
    roundScore = 0;

    document.getElementById('current-0').textContent = '0';
    document.getElementById('current-1').textContent = '0';

    document.querySelector('.player-0-panel').classList.toggle('active');
    document.querySelector('.player-1-panel').classList.toggle('active');

    

    document.querySelector('.dice').style.display = 'none';
    document.querySelector('.dice1').style.display = 'none';
}

document.querySelector('.btn-new').addEventListener('click', init);

function init() {
    globalScores = [0, 0];
    activePlayer = 0;
    roundScore = 0;
    gamePlaying = true;
    count= document.getElementById("limit").value;
    document.querySelector('.dice').style.display = 'none';
    document.querySelector('.dice1').style.display = 'none';
    document.getElementById('score-0').textContent = '0';
    document.getElementById('score-1').textContent = '0';
    document.getElementById('current-0').textContent = '0';
    document.getElementById('current-1').textContent = '0';
    document.getElementById('name-0').textContent = 'Player 1';
    document.getElementById('name-1').textContent = 'Player 2';
    document.querySelector('.player-0-panel').classList.remove('winner');
    document.querySelector('.player-1-panel').classList.remove('winner');
    document.querySelector('.player-0-panel').classList.remove('active');
    document.querySelector('.player-1-panel').classList.remove('active');
    document.querySelector('.player-0-panel').classList.add('active');
}










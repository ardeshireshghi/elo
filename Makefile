staging:
	git push -v --force heroku-staging HEAD:master

prod:
	git push -v --force heroku-prod HEAD:master

pg:
	pgcli postgres://elo@localhost:5445/elo


# SuperStoreAndroid

this is for the developers
Note Do not push to dev branch Delete print

Admin
Email - jake@gmail.com password - testing123

API endpoints
For Login

For Purchases

For Shops

For Items

For Sales

For product-batch

For each product-batch

it won't work until you switch pk with an integer
pk stand for primary key.
Paid or not paid each product-batch

Register Clerk

For Clerk

For each Clerk

it won't work until you switch pk with an integer
pk stand for primary key.
Activate or Deactive each Clerk

Register Merchant

For Merchant

For each Merchant

it won't work until you switch pk with an integer
pk stand for primary key.
Register Manager

For Manager

For each Manager

it won't work until you switch pk with an integer
pk stand for primary key.
Activate or Deactive each Manager

Runing it on your local server
Creating a virtual environment


$ sudo apt-get install python3-venv
$ python3 -m venv virtual
Activating the virtual environment


$ . virtual/bin/activate
Install all dependencies with the code bellow before you begin

$ pip install -r requirements.txt
Setting up a database on Remotely
First type psql in your terminal

$ psql
Second in the shell type CREATE DATABASE shop;

$ psql
psql (12.2 (Ubuntu 12.2-4))
Type "help" for help.

david=# CREATE DATABASE shop;
Conform you will know if it's successful when you see CREATE DATABASE

$ psql
psql (12.2 (Ubuntu 12.2-4))
Type "help" for help.

david=# CREATE DATABASE shop;
CREATE DATABASE
david=#
then you
Create a file named .env

In that file type the code below:

source virtual/bin/activate

export DB_NAME='shop'
export DB_USER='username of your database'
export DB_PASSWORD='password of your database'
export SECRET_KEY='< your secert key >'
export DEBUG=True
Then you go to your terminal and type this to run this application

$ . .env
$ python3 manage.py runserver

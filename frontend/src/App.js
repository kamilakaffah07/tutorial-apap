import React from "react";

import List from "components/List";

import listMovies from "movies.json";

import "./App.css";
import { Switch } from "antd";

export default class App extends React.Component{
  state ={
    favItems: [],
    checked: false
  };
  constructor(){
  super()
  this.handleChange = this.handleChange.bind(this);
  };

  handleChange(checked){
    this.setState({checked: checked})
  };

  handleItemClick = (item) =>{
    const newItems =  [...this.state.favItems];
    const newItem = {...item};
    const targetInd = newItems.findIndex((it)=> it.id === newItem.id);
  
    if(targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd,1); 
    
    this.setState({favItems: newItems})
  };

  handleItemAdd = (item) =>{
    const newItems =  [...this.state.favItems];
    const newItem = {...item};
    const targetInd = newItems.findIndex((it)=> it.id === newItem.id);
  
    if(targetInd < 0) newItems.push(newItem);
    //else newItems.splice(targetInd,1); 
    
    this.setState({favItems: newItems})
  };

  handleDelete = () => {
    this.setState({favItems: []});
  }

  render(){
    const{favItems} = this.state
    return(
      
      <div className ="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favourites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong>application)
        </p>
        <div className="text-center container-fluid align-items-center">
          <Switch
            className = "react-witch"
            onChange = {this.handleChange}
            checked = {this.state.checked}
          /><p><strong>Show Favorites</strong></p>
        </div>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="List Movies"
                items={listMovies}
                onItemClick={this.handleItemAdd}
                />
            </div>
              <div className="col-sm">
              <b> {this.state.checked ?
              <div>
                <List 
                  title="My Favorites"
                  items = {favItems}
                  onItemClick={this.handleItemClick}              
                />
                {this.state.favItems.length === 0 && <h4 className="text-center mt-3 mb-0" >Belum ada item yang dipilih</h4>}
                {this.state.favItems.length === 0 && <p className="text-center">Klik salah satu item di Movie List</p>}
                {this.state.favItems.length > 0 && <button type="button" onClick={this.handleDelete}>Delete</button>}
              </div>
              : null
              }</b>
            </div>
          </div>
        </div>
      </div>
    )
  };
};

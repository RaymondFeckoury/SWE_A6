import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { bmsApiService } from '../../services/bmsapi.service';

@Component({
  selector: 'app-add-new-movie',
  templateUrl: './add-new-movie.component.html',
  styleUrls: ['./add-new-movie.component.scss']
})
export class AddNewMovieComponent implements OnInit {
  addMovie: FormGroup;
  genres = ["Action","Horror","Thriller","Comedy","Drama","Adventure","Documentary","Fiction","Mystery","Animation"];
  ratings = ["G: General Audiences","PG: Parental Guidance Suggested","PG-13: Parents Strongly Cautioned","R: Restricted","NC-17: Clearly Adult"];
  constructor(private fb: FormBuilder, private _bmsAs:bmsApiService) {
   }

  ngOnInit(): void {
    this.genres = ["Action","Horror","Thriller","Comedy","Drama","Adventure","Documentary","Fiction","Mystery","Animation"];
    this.ratings = ["G: General Audiences","PG: Parental Guidance Suggested","PG-13: Parents Strongly Cautioned","R: Restricted","NC-17: Clearly Adult"];
    this.addMovie = this.fb.group({
      title : ['',[Validators.required]],
      Synopsis : ['', [Validators.required]],
      cast: ['',[Validators.required]],
      trailerLink : ['', [Validators.required]],
      thumbnail : ['',[Validators.required]],
      genre: ['',[Validators.required]],
      rating: ['', [Validators.required]],
      director: ['', [Validators.required]],
      writer: ['',[Validators.required]],
      startDate: ['',[Validators.required]],
      endDate: ['',[Validators.required]],
      year: ['',[Validators.required]]
    });
  };

  ngAfterViewInit() {
    this.genres = ["Action","Horror","Thriller","Comedy","Drama","Adventure","Documentary","Fiction","Mystery","Animation"];
    this.ratings = ["G: General Audiences","PG: Parental Guidance Suggested","PG-13: Parents Strongly Cautioned","R: Restricted","NC-17: Clearly Adult"];
  }

  addNewMovie() {
    console.log(this.addMovie.value);
    var data =  {
      "title": "coolmovie3",
      "cast": "lots of folks3",
      "director": "me duh3",
      "producer": "big dawg3",
      "synopsis": "idk what this is3",
      "category": "action3",
      "rating": "pg-133"
    };
    let data2 = JSON.stringify(data);
    this._bmsAs.addMovie(data2).subscribe(res=>{
      console.log(res," put method result");
    });
  }

  updateGenre(evt:any) {

  }

  updateRating(evt:any) {

  }

}

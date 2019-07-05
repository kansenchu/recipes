package co.softbank.recieverecipe.responses;

import co.softbank.recieverecipe.models.Recipe;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
public class RecipeResponse {
  final String message;
  final List<Recipe> recipe;
}
package action

sealed class StateAction {
    data object FetchData:StateAction()
}
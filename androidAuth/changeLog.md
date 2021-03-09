# Changelog
All notable changes to this project will be documented in this file.

## [2.0.0] - 2020-11-19
### Changed
- Went from token:LiveData<String> to authFlow:Flow<AuthEvent> API.
- Went from user:LiveData<User> to session:LiveData<Session> API.
- Fix rotation bug.

### Added
- Response object from Retrofit now wraps around endpoint response values
for better error handling in the next layer up.

- SessionFactory produces a read-only Session object that wraps
User data.

### Removed
- User data from the UI layer.

## [0.5.0] - 2020-11-19
### Added
- Encryption
- Error Response Handling
- ChangeLog

## [Unreleased]
- Remember Me System
- OAuth
- Configure Token Expiration

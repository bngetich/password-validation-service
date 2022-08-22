# password-validation-service
A service that checks if password is compliant to validation rules.

It is configurable via spring boot dependency injection.

1. currently checks for the following:

    password must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.

    password must be between 5 and 12 characters in length.

    password must not contain any sequence of characters immediately followed by the same sequence.

2. can be configured to check for a different set of things by dependency-injecting a different validator bundle to the service.

3. new validation bundle components (ie - new validations) can be created by creating extending the PasswordValidatorComponentDecorator abstract class

